package alcChallenge.com;

public class Profile {

    private final byte [] avatar;
    private final String track;
    private final String country;
    private final String phone;
    private final String username;
    private final String email;


    public Profile(byte [] avatar, String track, String country, String phone, String username, String email) {
        this.avatar = avatar;
        this.track = track;
        this.country = country;
        this.phone = phone;
        this.username = username;
        this.email = email;
    }


    public byte[] getAvatar()
    {
        return avatar;
    }

    public String getTrack()
    {
        return track;
    }

    public String getCountry()
    {
        return country;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getUsername ()
    {
        return username;
    }

    public String getEmail ()
    {
        return email;
    }






}
