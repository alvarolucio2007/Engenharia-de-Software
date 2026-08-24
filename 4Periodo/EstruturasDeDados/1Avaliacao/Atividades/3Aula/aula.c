#include <stdio.h>
int main() {
  int product_price = 10;
  int new_product_price;
  do {

    printf("Please insert the price of the product\n");
    scanf("%d", &new_product_price);
  } while (product_price > new_product_price);
  product_price = new_product_price;
  return 0;
}
