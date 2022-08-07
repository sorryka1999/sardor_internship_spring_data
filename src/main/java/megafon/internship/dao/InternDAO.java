package megafon.internship.dao;

public class InternDAO {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String hobby;

    public InternDAO() {
    }

    public InternDAO(Long id, String name, String surname, Integer age, String hobby) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.hobby = hobby;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
