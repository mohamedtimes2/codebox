#include <stdio.h>
#include <stdlib.h>

int main()
{
    char adjective[20];
    char noun[20];
    char plunoun[20];
    char person[10];
    printf("They are many {adjective} ways to choose a/an {noun} to read.\n");
    printf("First, you could ask for recommendation from your friends and {plural noun}.\n");
    printf("Just don't ask Aunt {person in room (female)}.\n");
    printf("Input a adjective: \n");
    scanf("%s", adjective);
    printf("Input a noun: \n");
    scanf("%s", noun);
    printf("Input a plural noun: \n");
    scanf("%s", plunoun);
    printf("Input a female person's name: \n");
    scanf("%s", person);
    printf("\n");
    printf("Finished Mad-libs\n");
    printf("--------------------------------\n");
    printf("They are many %s ways to choose a/an %s to read.\n", adjective, noun);
    printf("First, you could ask for recommendation from your friends and %s.\n", plunoun);
    printf("Just don't ask Aunt %s.\n", person);
}
