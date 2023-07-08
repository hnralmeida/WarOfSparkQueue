/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cgt;

import cdp.Creature;
import dao.*;
import cdp.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author almei
 */
public class DAOManager {

    private final GenericDAO genDao;
    private final MatchDAO MatchDao;
    private final PlayerDAO PlayerDao;
    private final CampaignDAO CampDao;
    private final CreatureDAO CreaDao;

    public DAOManager() throws ClassNotFoundException, SQLException {
        // Realizar conexão com Hibernate
        ConnectionApp.getSessionFactory();

        genDao = new GenericDAO();
        MatchDao = new MatchDAO();
        PlayerDao = new PlayerDAO();
        CampDao = new CampaignDAO();
        CreaDao = new CreatureDAO();
    }

    /*
    * Função genérica para listar
    *
    * @param classe
    * @throws SQLException
    * @throws ClassNotFoundException
    * @returns genericDAO.listar(classe)
     */
    public List listar(Class classe) throws ClassNotFoundException, SQLException {
        return genDao.listar(classe);
    }

    /*
    * Inserir uma nova partida no banco (após a mesma ocorrer)
    *
    * @param team (teamA)
    * @param enemy (teamB)
    * @param player
    * @param dateEvent
    * @throws SQLException
    * @throws ClassNotFoundException
     */
    public void insertMatch(
            ArrayList<Creature> team,
            ArrayList<Creature> enemy,
            Player player,
            Date dateEvent
    ) throws ClassNotFoundException, SQLException {
        Match match = new Match(team, enemy, dateEvent, player);
        MatchDao.inserir(match);
    }

    /*
    * Inserir uma nova partida no banco (após a mesma ocorrer)
    *
    * @param team (teamA)
    * @param enemy (teamB)
    * @param player
    * @param dateEvent
    * @throws SQLException
    * @throws ClassNotFoundException
     */
    public void insertMatch(
            Match match
    ) {
        /*LinkedList<Creature> hero = match.getTeamA();;
        LinkedList<Creature> enemy = match.getTeamB();
        
        for (Creature cre : hero) {
            cre.getMatchTA().add(match);
        }
        for (Creature cre : enemy) {
            cre.getMatchTA().add(match);
        }*/
        MatchDao.inserir(match);
    }

    /*
    * Cadastrar um novo usuário
    *
    * @param name
    * @param token da senha
    * @param currency (default=0)
    * @param pic
    * @throws SQLException
    * @throws ClassNotFoundException
     */
    public void insertPlayer(
            String name,
            String email,
            String dtNasc,
            String token,
            int currency,
            byte[] pic
    ) throws ClassNotFoundException, SQLException {
        Player p1 = new Player(name, email, dtNasc, token, currency, pic);

        Player p = this.findPlayer(email, token);

        if (p == null) {
            PlayerDao.inserir(p1);
            p = this.findPlayer(email, token);
            // ======================================= //
            /* Initialize the team (will be only one)*/
            List<Creature> nlistinit = new ArrayList<>();
            insertTeam(p, nlistinit);
            // ======================================= //
            /* Get a Soldier for team*/
            insertTeam(p, nlistinit);
            Team team = findTeam(p.getId()).get(0);
            insertCreature(70, 18, "Soldier", 1, 0, team);
        }
    }

    /*
    * Cadastrar um novo usuário
    *
    * @param name
    * @param position
    * @param team
    * @throws SQLException
    * @throws ClassNotFoundException
     */
    public void insertCampaign(
            String name,
            int position,
            Player p,
            List<Creature> team
    ) throws ClassNotFoundException, SQLException {
        // List Creatures, String name, int position, int idPlayer
        CampaignMatch camp = new CampaignMatch(team, name, position, p);
        CampDao.inserir(camp);
        /*
        for (Creature co : team) {
            CreatureDAO.alterar(idPlayer);
        }*/
    }

    /*
    * Cadastrar uma nova criatura em uma campanha
    *
    * @param name
    * @param position
    * @param team
    * @throws SQLException
    * @throws ClassNotFoundException
     */
    public void insertCreature(
            int weight,
            int age,
            String name,
            int idInterface,
            int price,
            CampaignMatch matchCampaign
    ) throws ClassNotFoundException, SQLException {
        Creature c = new Creature(weight, age, name, idInterface, price, matchCampaign);

        CreaDao.inserir(c);
    }

    /*
    * Cadastrar uma nova criatura em um time
    *
    * @param name
    * @param position
    * @param team
    * @throws SQLException
    * @throws ClassNotFoundException
     */
    public void insertCreature(
            int weight,
            int age,
            String name,
            int idInterface,
            int price,
            Team team
    ) throws ClassNotFoundException, SQLException {
        Creature c = new Creature(weight, age, name, idInterface, price, team);

        CreaDao.inserir(c);
    }

    /*
    * Cadastrar uma nova criatura sem partida
    *
    * @param name
    * @param position
    * @param team
    * @throws SQLException
    * @throws ClassNotFoundException
     */
    public void insertCreature(
            int weight,
            int age,
            String name,
            int idInterface,
            int price
    ) throws ClassNotFoundException, SQLException {
        Creature c = new Creature(weight, age, name, idInterface, price);

        CreaDao.inserir(c);
    }

    /*
    * Cadastrar um novo usuário
    *
    * @param name
    * @param token da senha
    * @param currency (default=0)
    * @param pic
    * @throws SQLException
    * @throws ClassNotFoundException
     */
    public void insertTeam(
            Player tPlayer,
            List<Creature> team
    ) throws ClassNotFoundException, SQLException {
        Team t1 = new Team(team, tPlayer);
        PlayerDao.inserir(t1);
    }

    /*
    * Encontrar todas campanhas do usuário
    *
    * @param tPlayer Jogador Logado
    * @throws HibernateException
     */
    public void updateTeam(
            Player tPlayer,
            Team team
    ) throws HibernateException {
        List plist = TeamDAO.findAll(tPlayer.getId());
        if (!plist.isEmpty()) {
            TeamDAO newTemp = new TeamDAO();
            newTemp.alterar(team);
        }
    }

    /*
    * Encontrar todas campanhas do usuário
    *
    * @param tPlayer Jogador Logado
    * @throws HibernateException
     */
    public void updatePlayer(
            Player tPlayer
    ) throws HibernateException {
        PlayerDAO newTemp = new PlayerDAO();
        newTemp.alterar(tPlayer);
    }

    /*
    * Encontrar um usuário para login
    *
    * @param email
    * @param token da senha
    * @throws HibernateException
     */
    public Player findPlayer(
            String email,
            String token
    ) throws HibernateException {
        List plist = PlayerDao.findPlayer(email, token);
        if (plist == null) {
            return null;
        } else {
            Player user = (Player) plist.get(0);
            if (user.getToken().equals(token)) {
                return user;
            } else {
                return null;
            }
        }
    }

    /*
    * Encontrar todas campanhas do usuário
    *
    * @param idPlayer Jogador Logado
    * @throws HibernateException
     */
    public List<Match> findMatchByPlayer(
            Player idPlayer
    ) throws HibernateException {
        List plist = MatchDAO.findAll(idPlayer);
        if (plist == null) {
            return null;
        } else {
            return plist;
        }
    }

    /*
    * Encontrar todas campanhas do usuário
    *
    * @param idPlayer Jogador Logado
    * @throws HibernateException
     */
    public List<CampaignMatch> findCampaigns() throws HibernateException {
        List plist = CampaignDAO.findAll();
        if (plist == null) {
            return null;
        } else {
            return plist;
        }
    }

    /*
    * Encontrar todas campanhas do usuário
    *
    * @param idPlayer Jogador Logado
    * @throws HibernateException
     */
    public Creature findCreature(
            int idCreature
    ) throws HibernateException {
        Creature c = CreatureDAO.find(idCreature).get(0);
        if (c == null) {
            return null;
        } else {
            return c;
        }
    }

    /*
    * Encontrar todas criaturas
    *
    * @param idPlayer Jogador Logado
    * @throws HibernateException
     */
    public List<Creature> findAllCreatures(
            int idPlayer
    ) throws HibernateException {
        List plist = CreatureDAO.findAll();
        if (plist == null) {
            return null;
        } else {
            return plist;
        }
    }

    /*
    * Encontrar todas campanhas do usuário
    *
    * @param idPlayer Jogador Logado
    * @throws HibernateException
     */
    public List<Team> findTeam(
            int idPlayer
    ) throws HibernateException {
        List plist = TeamDAO.findAll(idPlayer);
        if (plist == null) {
            return null;
        } else {
            return (List<Team>) plist;
        }
    }

    /*
    * Cadastrar uma nova criatura em um time
    *
    * @param name
    * @param position
    * @param team
    * @throws SQLException
    * @throws ClassNotFoundException
     */
    public void removeCreature(
            Creature creature
    ) throws ClassNotFoundException, SQLException {
        creature.setTeam(null);
        CreaDao.alterar(creature);
    }

}
