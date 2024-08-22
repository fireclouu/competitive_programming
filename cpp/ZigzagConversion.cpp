#include <iostream>
#include <vector>
#include <string>
class Solution {
public:
  std::string convert(std::string s, int numRows) {
    if (numRows == 1) return s;
    std::string returnValue;
    returnValue.reserve(s.size());
    int ptrLeft = (numRows - 1) * 2, ptrRight = 0;
    bool isLeft;
    for (int i = 0; i < numRows; i++) {
      for (int j = i; j < s.length();) {
        returnValue.push_back(s[j]);
        isLeft = ptrLeft != 0 && ((ptrLeft != 0 && ptrRight == 0) || !isLeft);
        j = isLeft ? j+ptrLeft : j+ptrRight;
      }
      isLeft = false;
      ptrLeft -= 2;
      ptrRight += 2;
    }
    return returnValue;
    // old method, heuristic
    /*
    if (numRows == 1) return s;
    std::vector<std::vector<char>> zz(numRows);
    int diagonal = numRows - 2;

    int row = 0, diag = 0;
    for (int i = 0; i < s.length(); i++) {3
      if (row == numRows && diag == diagonal) {
        diag = 0;
        row = 0;
      }
      if (row < numRows) {
        zz[row++].push_back(s[i]);
      } else {
        zz[numRows-1 - ++diag].push_back(s[i]);
      }
    }

    for (int i = 0; i < zz.size(); i++) {
      returnValue.append(zz[i].begin(), zz[i].end());
    }
    return returnValue;
    */
  }
};

int main() {
  Solution sol;
  std::string s1 = sol.convert("PAYPALISHIRING", 3) == "PAHNAPLSIIGYIR" ? "OKAY" : "FAIL";
  std::string s2 = sol.convert("PAYPALISHIRING", 4) == "PINALSIGYAHRPI" ? "OKAY" : "FAIL";
  std::cout << "TEST 1: " << s1 << std::endl;
  std::cout << "TEST 2: " << s2 << std::endl;
  return 0;
}
