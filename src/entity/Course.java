@Entity
@Table(name="courses")
public class Course{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String name;
    private List<String> topics;
    private String author;

    protected Course(){};

    public Course(String name, List<String> topics, String author){
        this.name = name;
        this.topics = topics;
        this.author = author;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getTopics() {
        return topics;
    }

    public String getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}