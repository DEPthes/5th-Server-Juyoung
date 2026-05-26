package hellojpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String name;


    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

    @OneToOne
    @JoinColumn(name="JOIN_ID")
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    public Team getTeam() {
        return team;
    }

//    public void changeTeam(Team team) {
//        this.team = team;
//
//        team.getMembers().add(this);
//    }


    public Member(){

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

    public void setTeam(Team team) {
    }
}
