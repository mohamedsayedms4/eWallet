
# 💳 E-Wallet System - eraa-soft

## 📋 Project Overview
A robust Java-based E-Wallet application implementing core banking features with secure account management, developed over **16 intensive hours** of design and implementation.

## ✨ Key Features
- **Advanced Design Patterns**:
  - Builder Pattern for flexible account creation
  - Singleton Pattern for wallet instance management
- **Secure Financial Operations**:
  - Deposit/withdrawal with balance validation
  - Inter-account money transfers
  - Account balance management
- **Strict Validation**:
  - Username/password requirements
  - Phone number format checking
  - Age verification (18-80 years)
- **Account Management**:
  - Profile viewing
  - Password changes with old password verification

## 🏗️ Project Structure
src/
├── model/ # Core data models
│   ├── Account.java # Account model with Builder
│   └── EWallet.java # Singleton wallet instance
│
├── service/ # Service interfaces
│   ├── AccountService.java
│   ├── ApplicationService.java
│   ├── loginFeatures.java
│   └── [other interfaces...]
│
└── service/implementation/ # Service implementations
    ├── AccountServiceImpl.java
    ├── [other implementations...]

## ⚙️ Requirements
- Java 17 or higher
- Any Java IDE (IntelliJ IDEA recommended)

## 🚀 Launch Instructions
1. Clone the repository
2. Open in your preferred Java IDE
3. Run `ApplicationServiceImpl.java`

```bash
git clone [repository-url]
cd e-wallet-system
# Open in IDE and run main application class
```

## 🔐 Validation Rules
| Field    | Requirements                             |
|----------|----------------------------------------|
| Username | ≥3 chars, starts with uppercase        |
| Password | 6+ chars with: uppercase, lowercase, number, special char (#$@&) |
| Age      | Between 18-80 years                    |
| Phone    | 12 digits starting with '2'             |

## 💰 Financial Operations
**Deposit:**
- Add funds to any account
- Immediate balance update

**Withdrawal:**
- Funds deduction with balance check
- Returns status codes for different scenarios

**Transfer:**
- Secure inter-account transactions
- Full validation of both accounts

## ⏳ Development Effort
| Task                 | Hours  |
|----------------------|--------|
| Architecture Design  | 4      |
| Core Implementation  | 8      |
| Testing & Debugging  | 4      |
| **Total**           | **16** |

## 📝 Implementation Notes
- Follows SOLID principles
- Clean separation of concerns
- Well-documented code
- Easy to extend with new features

## 🔮 Potential Future Improvements
- Graphical user interface
- Database persistence
- Transaction history

## 🤝 Contribution
Contributions are welcome! Please submit pull requests for any improvements or bug fixes.

---

## 📞 Contact
For support or questions, please open an issue on the repository or contact the maintainer.

---

![Java 17](https://img.shields.io/badge/Java-17-brightgreen)
![Design Patterns](https://img.shields.io/badge/Design_Patterns-Builder%20%7C%20Singleton-blue)

