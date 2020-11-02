#include <stdio.h>
#include <stdlib.h>

int main()
{
    double num1;
    double num2;
    char op;
    printf("Enter first number: \n");
    scanf("%lf", &num1);
    printf("Enter operator: \n");
    scanf(" %c", &op);
    printf("Enter second number: \n");
    scanf("%lf", &num2);
    if (op == '+') {
        printf("%f", num1 + num2);
    }
    else if (op == '-') {
        printf("%f", num1 - num2);
    }
    else if (op == '*') {
        printf("%f", num1 * num2);
    }
    else if {
        printf("%f", num1 / num2);
    }
    else {
        printf("An error has occurred. Please restart the program.");
    }
    return 0;
}
