/*
  This source file contains a basic implementation of the queue data structure using singly linked-list in c++.
  Different ways to interact with the queue (enqueue, dequeue and display) are provided in the interface.
*/

#include <iostream>

using namespace std;

// Node structure for the linked list
struct QueueNode
{
    int data, queuePos; // Data of the node and its position in the queue
    QueueNode* next;     // Pointer to the next node

    // Constructor for initializing a node with given data
    QueueNode(int value) : data(value), next(NULL) {}
};

// Queue implementation using linked list
class MyQueue
{
private:
    QueueNode* f;         // Front of the queue
    QueueNode* r;         // Rear of the queue
    int lastQueuePos;     // Last assigned queue position

    // Check if the queue is empty
    bool isEmpty()
    {
        return f == NULL;
    }

public:
    // Constructor
    MyQueue() : f(NULL), r(NULL), lastQueuePos(0) {}

    // Destructor to free memory on object destruction
    ~MyQueue()
    {
        while (!isEmpty()) dequeue();
    }

    // Method to enqueue a new element into the queue
    void enqueue(int value)
    {
        QueueNode* newNode = new QueueNode(value);

        // If the queue is empty, set front and rear to the new node
        if (isEmpty())
        {
            f = r = newNode;
            lastQueuePos = 0;
        }
        else
        {
            r->next = newNode; // Connect the current rear to the new node
            r = newNode;       // Move the rear pointer to the new node
        }
        r->queuePos = lastQueuePos; // Set the queue position for the new node
        lastQueuePos++;
    }

    // Method to dequeue an element from the queue
    bool dequeue()
    {
        if (isEmpty()) return false; // Queue is empty, dequeue failed

        QueueNode* temp = f; // Temporary pointer to the front node
        f = f->next;        // Move the front pointer to the next node
        delete temp;        // Delete the front node
        return true;
    }

    // Method to display the contents of the queue
    void display()
    {
        if (isEmpty())
        {
            cout << "The Queue is Empty." << endl << endl;
            return;
        }

        system("cls");
        cout << "DISPLAY QUEUE:" << endl << endl;
        QueueNode* displayPtr = f;

        // Iterate through the queue and display each element
        while (displayPtr != NULL)
        {
            cout << "Queue Position [" << displayPtr->queuePos << "] " << displayPtr->data << endl;
            displayPtr = displayPtr->next;
        }
        cout << endl;
    }
};

// Function to display the menu and get user input
int menu()
{
    int choice;
    cout << "Implementation of Queue using Linked List" << endl << endl;
    cout << "1. Enqueue" << endl;
    cout << "2. Dequeue" << endl;
    cout << "3. Display" << endl;
    cout << "4. Exit" << endl << endl;
    cout << "You selected: ";

    cin >> choice;
    return choice;
}

// Main function to interact with the queue
int main()
{
    MyQueue myQueue;
    int tempNum;

    while (true)
    {
        system("cls");
        switch (menu())
        {
        case 1:
            cout << "Enter the number to enqueue: ";
            cin >> tempNum;
            myQueue.enqueue(tempNum);
            cout << "\nElement " << tempNum << " was added to the queue.\n\n";
            break;
        case 2:
            cout << (myQueue.dequeue() ? "Dequeue successful." : "Dequeue failed: The Queue is Empty.") << endl << endl;
            break;
        case 3:
            myQueue.display();
            break;
        case 4:
            cout << "Thank you for using my program!" << endl << "Exiting..." << endl << endl;
            system("pause");
            exit(0);
        default:
            cout << "Please choose between 1 to 4." << endl << endl;
        }
        system("pause");
    }
}
