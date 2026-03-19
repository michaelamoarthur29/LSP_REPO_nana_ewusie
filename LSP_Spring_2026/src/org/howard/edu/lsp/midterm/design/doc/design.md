Class: Order
Responsibilities:
- Store order data (customerName, email, item, price)
- Provide access to order details
Collaborators:
- PricingService
- ReceiptService

---

Class: PricingService
Responsibilities:
- Calculate tax
- Apply discounts
- Compute total price
Collaborators:
- Order

---

Class: ReceiptService
Responsibilities:
- Generate and display receipt
Collaborators:
- Order
- PricingService

---

Class: OrderRepository
Responsibilities:
- Save order data to storage (file or database)
Collaborators:
- Order

---

Class: NotificationService
Responsibilities:
- Send confirmation email to customer
Collaborators:
- Order

---

Class: LoggerService
Responsibilities:
- Log order processing activity with timestamps
Collaborators:
- Order

---

Class: OrderProcessor
Responsibilities:
- Coordinate order processing workflow
- Delegate tasks to appropriate services
Collaborators:
- Order
- PricingService
- ReceiptService
- OrderRepository
- NotificationService
- LoggerService
