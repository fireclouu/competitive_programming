#include <iostream>
#include <string>

bool isSubsequence(std::string s, std::string t) {
  if (t.size() < s.size()) return false;

  int satisfy = 0;

  for (char item : t) {
    if (satisfy == s.size()) break;
    if (item == s[satisfy]) satisfy++;
  }

  return satisfy == s.size();
}
int main() {
  std::string input = "ahsbbdcjfn";
  std::string subseq = "axxbc";
  std::cout << isSubsequence(subseq, input) << std::endl;
  return 0;
}

