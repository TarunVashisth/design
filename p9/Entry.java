package problem9;

public class Entry {
	public static void ShowUI(Account account) {
		Dialog dlg= account.getDialog();
		if(dlg!=null) {
			dlg.Display();			
		}
	}
	public static void Save(Account account) {
		Dao dao=null;
		
		if(account instanceof SA) {
			dao = new SADao();
		}
		if(account instanceof CA) {
			dao = new CADao();
		}
		if(dao!=null) {
			dao.save(account);			
		}
	}
	static void main()
	{
		Account account = new SA();
		ShowUI(account);
		Save(account);
	}
}
