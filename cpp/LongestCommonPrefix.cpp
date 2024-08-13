#include <iostream>
#include <string>
#include <vector>

std::string longestCommonPrefix(std::vector<std::string>& strs) {
  if (strs.empty()) return "";
  int min = strs[0].length();
  for (std::string& item : strs) {
    min = item.length() > min ? min : item.length();
  }

  for (int charIndex = 0; charIndex < min; charIndex++) {
    for (int i = 1; i < strs.size(); i++) {
      if (strs[0][charIndex] != strs[i][charIndex]) return strs[0].substr(0, charIndex);
    }
  }
  return strs[0].substr(0, min);
}
int main() {
  std::vector<std::string> strs = { "abca", "aba", "aaab" };
  std::vector<std::string> strs2 = {"flower","reflow","flight"};
  std::vector<std::string> strs3 = {"flow","flow", "flower"};
  std::cout << "Max Prefix: " << longestCommonPrefix(strs) << std::endl;
  std::cout << "Max Prefix: " << longestCommonPrefix(strs2) << std::endl;
  std::cout << "Max Prefix: " << longestCommonPrefix(strs3) << std::endl;
  return 0;
}
