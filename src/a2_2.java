public class a2_2 {
    public static void main(String[] args) {
        AppConfig appcfg= AppConfig.getInstance();
        System.out.println(appcfg.getAppTitle());
        appcfg.setAppTitle("Tú aplicación");
        System.out.println(appcfg.getAppTitle());
        appcfg= AppConfig.getInstance();
        System.out.println(appcfg.getAppTitle());
    }
}
class AppConfig {
    private String appTitle;
    private static AppConfig instance=null;

    public static AppConfig getInstance() {
        if (instance == null){
            instance= new AppConfig();
        }
        return instance;
    }

    public String getAppTitle() {
        return appTitle;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }
    private AppConfig(){
        appTitle ="Mi Aplicación";
    }
}