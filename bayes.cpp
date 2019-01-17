#include <iostream>

using namespace std;


void construct_transition_table (string *state,double **transition_probability,int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << "probability of " << state [i] << " then " << state [j] << endl;
            cin >> transition_probability [i][j];
        }
    }
}


void construct_emision_table (string *state, string *expression, double **emision_probability, int n, int m)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cout << "probability of if " << state [i] << " then " << expression [j] << endl;
            cin >> emision_probability [i][j];
        }
    }
}


void print (string *state, double** transition_probability ,int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
            cout << " probability of " << state [i] << " " << state [j] << " is : "<< transition_probability [i][j];
    }
    cout << endl;
}



int main ()
{
    int n,m;
    cout << "how many state?\n";
    cin >> n;
    cout << "How many expression \n";
    cin >> m;
    string expression [m];
    string state[n];
    double **transition_probability  = new double*[n];
    
    for(int i=0;i<n;i++)   transition_probability[i] = new double[n];
     
    double **emision_probability = new double *[n];
    
    for(int i=0;i<n;i++)   emision_probability [i] = new double[m];

    cout << "Enter the State name \n";

    for (int i = 0; i < n; i++)
        cin >> state [i];

    cout << "Enter the expression name \n";

    for (int i = 0; i < m; i++)
        cin >> expression [i];

    construct_transition_table (state,transition_probability,n);
    construct_emision_table (state, expression, emision_probability, n, m);
    print (state, transition_probability, n);

	string emision ;
	double probabilityOfEmision;
	double probabilityOfState [n] = {0};
	double probabilityOfDay1, probabilityOfDay2;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			probabilityOfState [i] += .5*(transition_probability [j] [i] );
		}
		
		cout << "probability of state " << i+1 << " = " << probabilityOfState [i] << endl;
	}
	cout << "Enter the current emision : \n";
	cin >> emision;
	
	for (int i = 0; i < m; i++)
		if (expression [i] == emision)
		{
			probabilityOfDay1 = (emision_probability [0][i]*probabilityOfState [0])/(.5 * (emision_probability [0][i] + emision_probability [1][i]));
			probabilityOfDay2 = (emision_probability [1][i]*probabilityOfState [0])/(.5 * (emision_probability [0][i] + emision_probability [1][i]));
		}
		
	
	cout << "Probability of " << state [0] << "is : " << probabilityOfDay1 << endl;
	cout << "Probability of " << state [1] << "is : " << probabilityOfDay2 << endl;
	
    return 0;
}
