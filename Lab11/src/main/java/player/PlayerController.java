package player;


import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @GetMapping("/players")
    public String getPlayer() throws SQLException {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Player");
        PlayerRepository playerRepository=new PlayerRepository(entityManagerFactory);
        return playerRepository.listPlayers().toString();
    }

    @PostMapping(path="/players")
    public Player addPlayer( Player player) throws SQLException {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Player");
        PlayerRepository  playerRepository=new PlayerRepository(entityManagerFactory);
        playerRepository.create(player);
        return player;
    }
@PutMapping
    public void updatePlayer(String name, String nameModified) throws SQLException {
        EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("Player");
        PlayerRepository player=new PlayerRepository(entityManagerFactory);
        player.update(name,nameModified);
    }
    @DeleteMapping
    public void deletePlayer(int id) throws SQLException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Player");
        PlayerRepository player=new PlayerRepository(entityManagerFactory);
        player.delete(id);
    }


}
/*
 public class PlayerController {
  @Autowired
  private PlayerRepository playerRepository;

@GetMapping("/players")
public List<Player> getPlayers() {
    return playerRepository.findAll();
}

    @GetMapping("/players/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable(value = "id") Long playerId)
            throws ResourceNotFoundException {
       Player player=
                playerRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("Player not found on :: " + playerId));
        return ResponseEntity.ok().body(player);
    }
    @PostMapping("/players")
    public User createUser(@Valid @RequestBody Player player) {
        return playerRepository.save(player);
    }

    @PutMapping("/players/{id}")
    public ResponseEntity<User> updatePlayer(
            @PathVariable(value = "id") Long playerId, @Valid @RequestBody Player playerN)
            throws ResourceNotFoundException {
        Player player =
                playerRepository
                        .findById(playerId)
                        .orElseThrow(() -> new ResourceNotFoundException("Player not found on :: " + playerId));
       player.setName(playerN.getName());
        final Player updatedPlayer = playerRepository.save(player);
        return ResponseEntity.ok(updatedPlayerser);
    }
    @DeleteMapping("/players/{id}")
    public Map<String, Boolean> deletePlayer(@PathVariable(value = "id") Long id) throws Exception {
        Player player =
                playerRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Player not found on :: " + id));
        playerRepository.delete(player);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    */