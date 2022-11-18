package org.agoncal.quarkus.jdbc;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Random;

@ApplicationScoped // create one instance of this
public class ArtistRepository {

    public static final String INSERT_INTO_T_ARTISTS = "INSERT INTO t_artists (id, name, bio, created_date) " +
            "VALUES (?, ?, ?, ?)";
    public static final String SELECT_STMT = "SELECT id, name, bio, created_date FROM t_artists WHERE id = ?";
    @Inject
    DataSource dataSource;

    public void persist(Artist artist) throws SQLException {
        Connection conn = dataSource.getConnection();
        String sql = INSERT_INTO_T_ARTISTS;
        artist.setId(Math.abs(new Random().nextLong()));

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, artist.getId());
            ps.setString(2, artist.getName());
            ps.setString(3, artist.getBio());
            ps.setTimestamp(4, Timestamp.from(artist.getCreatedDate()));
            ps.executeUpdate();
        }
        conn.close();
    }

    public Artist findById(Long id) throws SQLException {
        Connection conn = dataSource.getConnection();
        String sql = SELECT_STMT;
        Artist artist = new Artist();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                artist.setId(rs.getLong(1));
                artist.setName(rs.getString(2));
                artist.setBio(rs.getString(3));
                artist.setCreatedDate(rs.getTimestamp(4).toInstant());
            }
        }
        conn.close();
        return artist;
    }
}
