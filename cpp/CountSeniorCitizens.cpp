#include <iostream>

using namespace std;
class Solution {
  public:
    int countSeniors(vector<string>& details) {
      int count = 0;
      for (string item : details) {
        if (((item[11] - '0') * 10) + (item[12] - '0') > 60) count++;
      }
      return count;
    }
};

int main() {
  Solution sol;
  vector<string> testcase = {"7868190130M7522","5303914400F9211","9273338290F4010"};
  cout << sol.countSeniors(testcase);
  return 0;
}
