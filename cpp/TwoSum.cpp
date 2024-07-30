#include <cstdint>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
  public:
    vector<int> twoSum(vector<int>& nums, int target) {
      vector<int> pair;

      for (int i=0; i < nums.size() && pair.size() != 2; i++) {
        for (int j=0; j < nums.size(); j++) {
          if (i == j) continue;
          if (nums[i] + nums[j] == target) {
            pair.push_back(i);
            pair.push_back(i);
            break;
          }
        }
      }
      return pair;
    }
};
