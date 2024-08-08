#include <iostream>

int maxProfit(std::vector<int>& prices) {
  int profit = 0, dayIndex = 0;
  for (int i = 0; i < prices.size(); i++) {
    if (prices[i] < prices[dayIndex]) dayIndex = i;
    else if (profit < prices[i] - prices[dayIndex]) {
      profit = prices[i] - prices[dayIndex];
    };
  }
  return profit;
}
int main() {
  std::vector<int> prices = {7,1,5,3,6,4};
  std::vector<int> prices2 = {7,6,5,4,3,2,1};
  std::vector<int> prices3 = {2,4,1};
  std::cout << maxProfit(prices2);

  return 0;
}
