# ⚡ Sorting Algorithms Master Sheet

Sorting is the foundation of many algorithms. Understanding the trade-offs between time, space, and stability is key for senior-level engineering.

## 📊 Complexity Comparison

| Algorithm          | Best       | Average    | Worst      | Space    | Stable |
|--------------------|------------|------------|------------|----------|--------|
| **Quicksort**      | O(n log n) | O(n log n) | O(n²)      | O(log n) | No     |
| **Mergesort**      | O(n log n) | O(n log n) | O(n log n) | O(n)     | Yes    |
| **Heapsort**       | O(n log n) | O(n log n) | O(n log n) | O(1)     | No     |
| **Insertion Sort** | O(n)       | O(n²)      | O(n²)      | O(1)     | Yes    |
| **Selection Sort** | O(n²)      | O(n²)      | O(n²)      | O(1)     | No     |
| **Bubble Sort**    | O(n)       | O(n²)      | O(n²)      | O(1)     | Yes    |

---

## 💡 Which one to choose?

| Scenario            | Recommendation                                    |
|---------------------|---------------------------------------------------|
| **General Purpose** | **Quicksort** (Usually fastest in practice).      |
| **Stable Sorting**  | **Mergesort** (Guaranteed O(n log n) and stable). |
| **Memory is tight** | **Heapsort** (O(1) extra space).                  |
| **Nearly Sorted**   | **Insertion Sort** (O(n) best case).              |
| **Small Datasets**  | **Insertion Sort** (Low overhead).                |

---

## 🛠 Key Concepts

### 1. Stability 🧱
A sorting algorithm is **stable** if it preserves the relative order of equal elements.
- *Example*: If you sort a list of "Orders" by "Date" and then by "Customer Name", a stable sort will keep the orders for the same customer chronologically sorted.

### 2. In-place 📍
An algorithm is **in-place** if it requires a constant amount of extra space (O(1)).
- *Examples*: Bubble Sort, Selection Sort, Insertion Sort, Heapsort.

---

## 🔍 Algorithm Breakdowns

- **Quicksort**: Divide and conquer. Picks a 'pivot' and partitions the array. Great for caching due to localized memory access.
- **Mergesort**: Divide and conquer. Splits array in half, sorts each, and merges. Used for sorting Linked Lists and external sorting.
- **Heapsort**: Build a Max-Heap and repeatedly extract the maximum element.
- **Insertion Sort**: Like sorting a hand of cards. Great for small arrays.
- **Selection Sort**: Repeatedly finds the minimum and swaps it to the front. Always O(n²) swaps.
