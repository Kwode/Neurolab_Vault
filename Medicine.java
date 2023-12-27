import java.sql.*;

public class Medicine extends Main{
	
	//Database connection details
	private static final String JDBC_URL = "";
	private static final String USERNAME = "";
	private static final String PASSWORD = ";"
	//Medicine attributes
	private String nafdacNumber;
	private String name;
	private String manufacturer;
	private String dosageForm;
	private int quantity;
	private String supplier;
	private String purchaseDate;
	private String expirationDate;
	private double cost;
	
	//Constructor
	public Medcine(String nafdacNumber, String name, String manufacturer, 
			String doageForm, int quantity, String supplier, String purchaseDate,
			String expirationDate, double cost) {
		this.nafdacNumber = nafdacNumber;
		this.name = name;
		this.manufacturer = manufacturer;
		this.dosageForm = dosageForm;
		this.quantity = quantity;
		this.supplier = supplier;
		this.purchaseDate = purchaseDate;
		this.expirationDate = expirationDate;
		this.cost = cost;
	}
	
	// Method to add a new medicine to the database
	public void addMedicine() {
		try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
			String sqlQuery = "INSERT INTO MedicineSupplies (nafdacNumber, name, manufacturer, dosageForm, quantity, supplier, purchaseDate, expirationDate, cost)" +
								"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
				preparedStatement.setString(1, nafdacNumber);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, manufacturer);
				preparedStatement.setString(4, dosageForm);
				preparedStatement.setInt(5, quantity);
				preparedStatement.setString(6, supplier);
				preparedStatement.setString(7, purchaseDate);
				preparedStatement.setString(8, expirationDate);
				preparedStatement.setDouble(9, cost);
				
			}
		}
	} catch(SQLException error) {
		error.printStackTrace();
	}
}


