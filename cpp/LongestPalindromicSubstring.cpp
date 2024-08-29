#include <string>
#include <iostream>
#include <vector>

class Solution {
public:
  std::string longestPalindrome(std::string s) {
        int min = 0, max = 0;
        for (int i = 0; i < s.length() && max - min < s.length(); ++i) {
          for (int j = i; j < s.length(); j++) {
            if (s[i] != s[j]) continue;
            // greater than max
            bool gtMax = (j-i)+1 >= (max-min)+1;
            for (int k = 0; (i+k)-(j-k) <= 1 && gtMax; ++k) {
              gtMax = s[i+k] == s[j-k];
            }
            if (!gtMax) continue;
            max = j+1;
            min = i;
          }
        }
        return s.substr(min, max - min);
    }
};

int main() {
  Solution solution;
  std::vector<std::vector<std::string>> map;
  map.push_back({"babad", "bab", "aba"});
  map.push_back({"aaarrbabab", "babab"});
  map.push_back({"aa", "aa"});
  map.push_back({"ab", "a", "b"});
  map.push_back({"tbaa", "aa"});
  int score = 0;
  for (std::vector<std::string>& unit : map) {
      std::string& input = unit[0];
      std::string output = solution.longestPalindrome(input);
      int isPassed = -1;
      std::cout << "input:  " << input << "\n";
      std::cout << "output: " << output << "\n";
      std::cout << "expect: ";
      for (int i = 1; i < unit.size(); i++) {
          std::string& expect = unit[i];
          if (output == expect && isPassed == -1) isPassed = i;
          std::cout << unit[i] << ", ";
      }
      if (isPassed) score++;
      std::string result = isPassed ? "PASSED" : "FAILED";
      std::cout << "\nResult: " << result << "\n\n";
  }
  std::cout << "Score: " << score << " out of " << map.size() << "\n";
}
