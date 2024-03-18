//Ivan Reeve D. Lopez | Display ASCII Code, Character and Frequency | November 14, 2023
#include <iostream>
#include <fstream>

using namespace std;

/*
Pseudocode
1. fetch each character from the file stream
2. for each character c in the line:
    if c does not exist yet, store its ascii code and character to the list
    otherwise increment the corresponding frequency count for that specific character
3. display the linked list
*/

typedef struct fchar{
    int ascii;
    char ch;
    int frequency;
    fchar *next;
    fchar(char c): ch(c), ascii((int) c), frequency(1), next(NULL) {}
}FCHAR;

class FrequencyCounter{
    private:
        FCHAR * head;
    public:
        FrequencyCounter() : head(NULL){}
        ~FrequencyCounter()
        {
            while (head != NULL)
            {
                FCHAR* temp = head;
                head = head->next;
                delete temp;
            }
        }
        void addChar(char c){
            FCHAR * newChar = new FCHAR(c);
            if (head == NULL){
                head = newChar;
            }
            else{
                FCHAR * a = head;
                FCHAR * b = head;

                while(a != NULL){
                    b = a;
                    a = a->next;//we use 2 variables because we can't really predict whether a->next is null or garbage data, so we need to store a copy of the last node we performed an operation on
                    if (b->ch == c){
                        b->frequency++;
                        return;
                    }
                }
                b->next = newChar;
            }
        }
        void displayList(){
            FCHAR * ptr = head;
            cout << "ASCII\tCHAR\tFREQUENCY" << endl;
            while (ptr != NULL){
                if (ptr->ascii == 10) cout << ptr->ascii << "\t" << "\\n" << "\t" << ptr->frequency << endl;
                else cout << ptr->ascii << "\t" << ptr->ch << "\t" << ptr->frequency << endl;
                ptr = ptr->next;
            }
        }
};

void countFrequency(string src){
    ifstream file(src);
    char c;
    FrequencyCounter fc;

    if (file.is_open()){
        while(file.get(c)){
            fc.addChar(c);
        }
        fc.displayList();
    }
}

int main(){

    countFrequency("file.txt");
}
