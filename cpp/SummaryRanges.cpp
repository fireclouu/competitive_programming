#include <iostream>
#include <map>
#include <string>
#include <utility>

std::vector<std::string> summaryRanges(std::vector<int>& nums) {
  std::vector<std::string> summary;
  if (nums.empty()) return summary;
  // uncomment for old method
  // int item, itemNext;
  for (int i=0; i<nums.size(); i++) {
    for (int j=0; ;j++) {
      // old method
      // checks the current index value, if not similar
      // to sequence expected, evaluates and push to memory
      // this cause more write and arithmetic
      // that traverse neighbor index back and forth
      // making it inefficient
      /*
      item=i+j>=nums.size() ? 0 : nums[i+j];
      itemNext=nums[i] == INT_MAX ? INT_MAX : nums[i]+j;
      if (i+j<nums.size() && item==itemNext) continue;
      if (j > 1) {
        summary.push_back(std::to_string(nums[i]) + "->" + std::to_string(nums[i+j-1]));
      } else {
        summary.push_back(std::to_string(nums[i]));
      }
      i += j-1;
      break;
      */

      // new method
      // immediately check next index value, and evaluates if
      // index reach last entry or expected sequence is interrupted
      // while avoiding out of bounds error
      if (i+j+1<nums.size() && nums[i+j]+1 == nums[i+j+1]) continue;
      if (j>0) {
        summary.push_back(std::to_string(nums[i]) + "->" + std::to_string(nums[i+j]));
      } else {
        summary.push_back(std::to_string(nums[i]));
      }
      i+=j;
      break;
    }
  }
  return summary;
}

int main() {
  std::vector<int> range1 = { -3,-2,0,1,2,4,5,6,8,9,11 };
  std::vector<int> range2 = {-2147483648,-2147483647,2147483647};
  std::vector<int> range3 = {0,1};
  std::vector<int> range4 = {-1};
  std::cout << "range1" << std::endl;
  for (std::string& item : summaryRanges(range1)) {
    std::cout << item << ", ";
  }
  return 0;
}
