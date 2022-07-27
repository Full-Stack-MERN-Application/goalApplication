public class main {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.myngp.com/v2/broadcastEmails?$top=20")
                .get()
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Basic YXBpdXNlcjo3QjkwMThCOS0xMUUxLTQyQTItODM1OS05RTY1NDA2RENGODk=")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.toString());
    }
}
