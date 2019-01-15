#include <iostream>

using namespace std;
/*
void construct_transition_table (string *state,double **transition_probability,int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << "probability of " << state [i] << " " << state [j] << endl;
            cin >> transition_probability [i][j];
        }
    }
}

void construct_emision_table (string *state, string *expression, double *emision_probability[], int n, int m)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cout << "probability of " << state [i] << " " << expression [j] << endl;
            cin >> emision_probability [i][j];
        }
    }
}

void print (string state, double* transition_probability [],int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
            cout << "probability of " << state [i] << " " << state [j] << "is : "<< transition_probability [i][j];
    }
}
*/
int main ()
{
    int n,m;
    cout << "how many state?\n";
    cin >> n;
    cout << "How many expression \n";
    cin >> m;
    string expression [m];
    string state[n];
    double transition_probability [n][n];
    double emision_probability [n][m];

    cout << "Enter the State name \n";

    for (int i = 0; i < n; i++)
        cin >> state [i];

    cout << "Enter the expression name \n";

    for (int i = 0; i < m; i++)
        cin >> expression [i];
/*
    construct_transition_table (state,transition_probability,n);
    construct_emision_table (state, expression, emision_probability, n, m);
    print (state, transition_probability, n);
*/
// transition probability table
    cout << "Construct transition table :\n ";
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << "probability of " << state [i] << " then " << state [j] << endl;
            cin >> transition_probability [i][j];
        }
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cout << "probability of if " << state [i] << " then " << expression [j] << endl;
            cin >> emision_probability [i][j];
        }
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
            cout << "probability of " << state [i] << " " << state [j] << " is : "<< transition_probability [i][j];
    }

    return 0;
}
