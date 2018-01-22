package com.netcracker.springcrudapp.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {
    private Integer id;
    private String name;
    private Collection<DownloadedSong> downloadedSongsById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<DownloadedSong> getDownloadedSongsById() {
        return downloadedSongsById;
    }

    public void setDownloadedSongsById(Collection<DownloadedSong> downloadedSongsById) {
        this.downloadedSongsById = downloadedSongsById;
    }
}
