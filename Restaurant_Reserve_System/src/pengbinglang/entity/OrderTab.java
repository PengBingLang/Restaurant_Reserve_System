package pengbinglang.entity;

public class OrderTab {

	private String OrderNumber = "";
	private int TableID = 0;
	private String ReserveDate = "";
	private int TimeLong = 2;
	private int GuestNumber = 2;// 人数
	private int GusetID = 1;
	private String GusetName = "";
	private String GusetPhome = "";
	private double ReserveMoney = 20.0;
	private double ConsumptionMoney = 0;
	private double InMoney = 0;
	private double OutMoney = 0;
	private String MoneyType = "";
	private String Order_State = "已预定";

	public String getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}

	public int getTableID() {
		return TableID;
	}

	public void setTableID(int tableID) {
		TableID = tableID;
	}

	public String getReserveDate() {
		return ReserveDate;
	}

	public void setReserveDate(String reserveDate) {
		ReserveDate = reserveDate;
	}

	public int getTimeLong() {
		return TimeLong;
	}

	public void setTimeLong(int timeLong) {
		TimeLong = timeLong;
	}

	public int getGuestNumber() {
		return GuestNumber;
	}

	public void setGuestNumber(int guestNumber) {
		GuestNumber = guestNumber;
	}

	public int getGusetID() {
		return GusetID;
	}

	public void setGusetID(int gusetID) {
		GusetID = gusetID;
	}

	public String getGusetName() {
		return GusetName;
	}

	public void setGusetName(String gusetName) {
		GusetName = gusetName;
	}

	public String getGusetPhome() {
		return GusetPhome;
	}

	public void setGusetPhome(String gusetPhome) {
		GusetPhome = gusetPhome;
	}

	public double getReserveMoney() {
		return ReserveMoney;
	}

	public void setReserveMoney(double reserveMoney) {
		ReserveMoney = reserveMoney;
	}

	public double getConsumptionMoney() {
		return ConsumptionMoney;
	}

	public void setConsumptionMoney(double consumptionMoney) {
		ConsumptionMoney = consumptionMoney;
	}

	public double getInMoney() {
		return InMoney;
	}

	public void setInMoney(double inMoney) {
		InMoney = inMoney;
	}

	public double getOutMoney() {
		return OutMoney;
	}

	public void setOutMoney(double outMoney) {
		OutMoney = outMoney;
	}

	public String getMoneyType() {
		return MoneyType;
	}

	public void setMoneyType(String moneyType) {
		MoneyType = moneyType;
	}

	public String getOrder_State() {
		return Order_State;
	}

	public void setOrder_State(String order_State) {
		Order_State = order_State;
	}
}
