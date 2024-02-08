/*
  This source file contains a basic implementation of the stack data structure using singly linked-list in c++.
  Different ways to interact with the stack (push, pop, peek and display) are available in the interface.
*/

#include <iostream>

using namespace std;

// Node structure for the stack
struct StackNode
{
    int data;
    StackNode* next;
    // Constructor
    StackNode(int value): data(value), next(NULL) {}
};

// Stack class
class MyStack
{
    private:
        StackNode* top;  // Pointer to the top of the stack
        int counter;     // Counter to keep track of the number of elements in the stack

        // Private helper function to check if the stack is empty
        bool isEmpty()
        {
            return top == NULL;
        }

    public:
        // Constructor
        MyStack(): top(NULL), counter(0) {};

        // Destructor
        ~MyStack()
        {
            // Destructor to delete all elements when the stack goes out of scope
            while (isEmpty())
                pop();
        }

        // Method to push a new element onto the stack
        void push(int value)
        {
            StackNode* newNode = new StackNode(value);
            newNode->next = top;
            top = newNode;
            counter++;
            cout << "Element " << value << " has been added to the stack.\n\n";
        }

        // Method to pop the top element from the stack
        bool pop()
        {
            if (isEmpty()) return false; // If the stack is empty, deletion failed

            StackNode* temp = top;
            top = top->next;
            delete temp;
            counter--;
            return true;
        }

        // Method to peek at the topmost element in the stack
        void peek()
        {
            system("cls");
            cout << "PEEK STACK:\n\n";
            if (isEmpty())
            {
                cout << "The Stack is Empty.\n\n";
                return;
            }
            cout << "Topmost element: " << top->data << "\n\n";
        }

        // Method to display all elements in the stack
        void display()
        {
            system("cls");
            cout << "DISPLAY STACK:\n\n";
            if (isEmpty())
            {
                cout << "The Stack is Empty.\n\n";
                return;
            }
            StackNode* displayPtr = top;
            int index = counter - 1;
            while (displayPtr != NULL)
            {
                cout << "Stack Layer[" << index << "] " << displayPtr->data << endl;
                index--;
                displayPtr = displayPtr->next;
            }
            cout << endl;
        }
};

// Function to display the menu and get user choice
int menu()
{
    int choice;
    cout << "Implementation of Stack using Singly Linked List\n\n";
    cout << "1. Push\n";
    cout << "2. Pop\n";
    cout << "3. Peek\n";
    cout << "4. Display\n";
    cout << "5. Exit\n\n";
    cout << "You selected: ";

    cin >> choice;
    return choice;
}

// Main function
int main()
{
    MyStack myStack;
    int tempNum;
    while (true)
    {
        system("cls");
        switch (menu())
        {
            case 1:
                cout << "Enter the number to push: ";
                cin >> tempNum;
                cout << endl;
                myStack.push(tempNum);
                break;
            case 2:
                cout << (myStack.pop() ? "The top layer was successfully removed." : "The Stack is Empty.") << "\n\n";
                break;
            case 3:
                myStack.peek();
                break;
            case 4:
                myStack.display();
                break;
            case 5:
                cout << "Thank you for using my program!\nExiting...\n\n";
                system("pause");
                exit(0);
            default: cout << "Please choose between 1 to 5.\n\n";
        }
        system("pause");
    }
}
