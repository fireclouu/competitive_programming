#include <iostream>
#include <ostream>
#include <string>

int main() {
  std::unordered_map<char, int> romanInteger = {
    {'I', 1},
    {'V', 5},
    {'X', 10},
    {'L', 50},
    {'C', 100},
    {'D', 500},
    {'M', 1000},
  };

  std::string str = "CIV";
  size_t strSize = str.size();
  /*
  for (int i = 0; i < strSize / 2; i++) {
    int lastIndex = strSize - 1 - i;
    str[lastIndex] += str[i];
    str[i] = str[lastIndex] - str[i];
    str[lastIndex] -= str[i];
  }
  */

  int lastNumber = 0;
  int result = 0;
  for(int i = strSize - 1; i >= 0; i--) {
    if (lastNumber > romanInteger[str[i]]) {
      result -= romanInteger[str[i]];
    } else {
      result = (romanInteger[str[i]]) + result;
    }
    lastNumber = romanInteger[str[i]];
  }

  std::cout << result << std::endl;
  return 0;
}
