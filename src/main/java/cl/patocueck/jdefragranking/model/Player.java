package cl.patocueck.jdefragranking.model;

public class Player {

    private String email;
    private String nombre;
    private String nick;
    private String nickNoColor;
    private String apellidos;
    private String password;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
        String nickTemp = "";
        nickTemp = nickTemp.replaceAll("^1", "");
        nickTemp = nickTemp.replaceAll("^2", "");
        nickTemp = nickTemp.replaceAll("^3", "");
        nickTemp = nickTemp.replaceAll("^4", "");
        nickTemp = nickTemp.replaceAll("^5", "");
        nickTemp = nickTemp.replaceAll("^6", "");
        nickTemp = nickTemp.replaceAll("^7", "");
        nickTemp = nickTemp.replaceAll("^8", "");
        nickTemp = nickTemp.replaceAll("^9", "");
        nickTemp = nickTemp.replaceAll("^0", "");
        this.nickNoColor = nickTemp;
    }

    public String getNickNoColor() {
        return nickNoColor;
    }

    public void setNickNoColor(String nickNoColor) {
        this.nickNoColor = nickNoColor;
    }
    
    public String getPassword() {
            return password;
    }

    public void setPassword(String password) {
            this.password = password;
    }

    public String getEmail() {
            return email;
    }

    public void setEmail(String email) {
            this.email = email;
    }

    public String getNombre() {
            return nombre;
    }

    public void setNombre(String nombre) {
            this.nombre = nombre;
    }

    public String getApellidos() {
            return apellidos;
    }

    public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
    }
}
