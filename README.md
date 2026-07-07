# 🚀 LeetcodeSolution  -- Automated LeetCode Sync

An automated, ultra-secure portfolio that pulls accepted solutions directly from LeetCode and backs them up into this private GitHub repository. 

Unlike standard browser extensions that demand broad read/write access to your entire GitHub account, this repository uses a sandboxed **GitHub Actions workflow** (`joshcai/leetcode-sync@v1.7`) that runs entirely within this specific project. Your other public and private repositories remain completely locked and safe.

---

## ⚙️ How It Works

* **Trigger:** The automation runs entirely on its own every single night at midnight UTC via a configured cron schedule. It can also be forced to sync manually at any time via the actions dashboard.
* **Smart Deduplication:** The script automatically scans your existing repository first. It only writes new files for problems you have solved since the last run.
* **Multi-Language Support:** Version 1.7 includes native file-extension mapping for database tracking languages (including PostgreSQL/SQL), clearing common backend processing bugs.

---

## 📁 Repository Structure

Your code updates settle neatly into the root directory under the following layout:
```text
├── .github/workflows/
│   └── sync_leetcode.yml     # The main automation script engine
└── my-submissions/           # 📦 WHERE YOUR SOLUTIONS LIVE
    ├── 0001-two-sum.py        
    ├── 0178-rank-scores.sql   
    └── ...
```

---

## 🧠 What is Inside the `my-submissions` Folder?

The `my-submissions` folder acts as your automated code portfolio. Every time you solve a problem, the script creates a dedicated code file for it using the following rules:

* **Clean Filenames:** Every file is labeled with its **four-digit LeetCode problem number** followed by the slug name of the problem (e.g., `0001-two-sum`, `0178-rank-scores`). This keeps your entire list sorted perfectly in numerical order.
* **Exact Code Solutions:** Inside each file is the **exact, successful source code** you wrote on LeetCode that passed 100% of the test cases. No boilerplate, just your raw, clean algorithmic logic.
* **Automatic Language Extensions:** The tool intelligently detects the programming language you used for that specific submission and applies the matching file extension automatically:
  * `.py` for Python
  * `.java` for Java
  * `.cpp` for C++
  * `.sql` for Database/PostgreSQL solutions
* **Latest & Best Attempt:** If you resolve a problem using a faster runtime or cleaner logic, the automation will intelligently overwrite the file with your best-performing version so your history never gets cluttered with duplicates.

---

## 🔄 How to Update Expired Credentials

Your LeetCode cookie sessions will naturally expire every 3 to 6 months (or immediately if you click "Log Out" on the LeetCode web browser). If your daily automation run throws a red failure mark, follow these quick steps to update your secret vault keys:

### Step 1: Capture New Cookies
1. Log into your account on [LeetCode](https://leetcode.com).
2. Right-click anywhere on the screen and select **Inspect** (or press **F12**) to open Developer Tools.
3. Head to the **Application** tab (Chrome/Edge) or **Storage** tab (Firefox).
4. Expand **Cookies** on the left menu and select `https://leetcode.com`.
5. Locate and double-click to copy the values for these two specific keys:
   * `LEETCODE_SESSION`
   * `csrftoken`

### Step 2: Swap the Keys on GitHub
1. Navigate back to this GitHub repository.
2. Click on **Settings** (the gear icon ⚙️) in the top toolbar.
3. On the left sidebar, click **Secrets and variables** -> **Actions**.
4. Scroll to the **Repository secrets** block at the bottom.
5. Click the **Pencil Icon (Edit)** next to `LEETCODE_SESSION`, paste your new token, and click **Update secret**.
6. Repeat the exact same step for `LEETCODE_CSRF_TOKEN`.

### Step 3: Verify the Connection
1. Head to the **Actions** tab at the top of this repository.
2. Select **Sync Leetcode** from the left-hand workflows panel.
3. Click the **Run workflow** dropdown on the right side and hit the green **Run workflow** button.
4. Watch for the spinning icon to turn into a clean **green checkmark** ✅ to confirm your secrets are securely working again!
