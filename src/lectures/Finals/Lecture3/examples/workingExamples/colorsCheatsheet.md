```java
import java.awt.Color;

// Root panel background
root.setBackground(new Color(245, 247, 250));

// Form panel
formPanel.setBackground(new Color(230, 240, 255));

// Button panel + button
buttonPanel.setBackground(new Color(245, 247, 250));
JButton saveButton = new JButton("Save");
saveButton.setBackground(new Color(33, 150, 243));
saveButton.setForeground(Color.WHITE);
saveButton.setFocusPainted(false); // optional nicer look
buttonPanel.add(saveButton);

// Label text color
JLabel nameLabel = new JLabel("Name:");
nameLabel.setForeground(new Color(40, 40, 40));
formPanel.add(nameLabel);

// Table colors
table.setBackground(Color.WHITE);
table.setForeground(new Color(20, 20, 20));
table.setGridColor(new Color(220, 220, 220));
table.setSelectionBackground(new Color(187, 222, 251));
table.setSelectionForeground(Color.BLACK);

// Table header colors
table.getTableHeader().setBackground(new Color(25, 118, 210));
table.getTableHeader().setForeground(Color.WHITE);
```
