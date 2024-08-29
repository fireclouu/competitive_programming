#include <string>
#include <iostream>

class Solution {
public:
  std::string longestPalindrome(std::string s) {
        int min = 0, max = s.length() != 0;
        for (int i = 0; i < s.length() && max - min < s.length(); ++i) {
          for (int j = i; j < s.length(); j++) {
            if (s[i] != s[j]) continue;
            // greater than max
            bool gtMax = (j-i)+1 >= (max-min)+1;
            for (int k = 0; j-k >= i+k && gtMax; ++k) {
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
  std::cout << solution.longestPalindrome("babad") << "\n";
  std::cout << solution.longestPalindrome("aaarrbabab") << "\n";
  std::cout << solution.longestPalindrome("aa") << "\n";
  std::cout << solution.longestPalindrome("ab") << "\n";
  std::cout << solution.longestPalindrome("tbaa") << "\n";
}


