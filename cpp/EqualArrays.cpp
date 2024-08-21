#include <iostream>
bool canBeEqual(std::vector<int>& target, std::vector<int>& arr) {
  std::sort(target.begin(), target.end());
  std::sort(arr.begin(), arr.end());
  for (int i = 0; i < arr.size(); i++) {
    if (target[i] != arr[i]) return false;
  }
  return true;
}

int main() {
  return 0;
}
