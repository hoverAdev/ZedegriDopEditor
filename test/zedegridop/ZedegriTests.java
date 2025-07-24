package zedegridop;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ZedegriTests {
    private static ObjectMapper mapper;

    @BeforeAll
    public static void setup() {
        mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
    }

    @Test
    public void testPlayerJsonIn() {
        Player expected = new Player();
        expected.setName("Jacob");
        expected.setHp(250);
        expected.setDef(0);
        expected.setEtherDefense(0);
        expected.setSpeed(50);
        expected.setAttack(80);
        expected.setPotential(50);
        expected.setAp(7);
        expected.setEp(7);

        File file = new File("examples/char.json");
        Player actual;
        try{
            actual = mapper.readValue(file, Player[].class)[0];
        }
        catch (Exception e) {
            fail(e.getMessage());
            return;
        }

        assertEquals(expected, actual);
    }

    @Test
    public void testEtherJsonIn() {
        EtherAttack expected = new EtherAttack();
        expected.setUser("Jacob");
        expected.setTitle("Power Driver");
        expected.setDescription("A strong hit charged with mystical force");
        expected.setEp(1);
        expected.setHits(1);
        expected.setAoe(false);
        expected.setAccuracy(90);
        expected.setMult(2.5);
        expected.setDazeTarget("");
        expected.setDazePercent(0);
        expected.setHeal(0);
        expected.setPurge(false);
        expected.setLeech(false);
        expected.setType(EtherAttackType.ATTACK);
        expected.setBurnTime(0);
        expected.setPoisonTime(0);
        expected.setPhysicalDefenseDebuff(0);
        expected.setPhysicalDefenseTime(0);
        expected.setPhysicalDefenseChance(0);
        expected.setPhysicalAttackDebuff(0);
        expected.setPhysicalAttackTime(2);
        expected.setPhysicalAttackChance(10);
        expected.setPhysicalDefenseUp(false);
        expected.setPhysicalAttackUp(false);
        expected.setEtherDefenseDebuff(0);
        expected.setEtherDefenseTime(0);
        expected.setEtherDefenseChance(0);
        expected.setEtherAttackDebuff(0);
        expected.setEtherAttackTime(0);
        expected.setEtherAttackChance(0);
        expected.setEtherDefenseUp(false);
        expected.setEtherAttackUp(false);
        expected.setSpeedUp(0);

        File file = new File("examples/ether.json");
        EtherAttack actual;
        try {
            actual = mapper.readValue(file, EtherAttack[].class)[0];
        }
        catch (Exception e) {
            fail(e.getMessage());
            return;
        }

        assertEquals(expected, actual);
    }

    @Test
    public void testEnemyJsonIn() {
        Enemy expected = new Enemy();
        expected.setName("No Enemy");
        expected.setType("Animal");
        expected.setHp(0);
        expected.setDef(0);
        expected.setEtherDefense(0);
        expected.setSpeed(255);
        expected.setAttack(0);
        expected.setPotential(0);
        expected.setAttacks(new ArrayList<>());

        File file = new File("examples/enemies.json");
        Enemy actual;
        try {
            actual = mapper.readValue(file, Enemy[].class)[0];
        }
        catch (Exception e) {
            fail(e.getMessage());
            return;
        }

        assertEquals(expected, actual);
    }

    @Test
    public void testEnemyAttackJsonIn() {
        EnemyAttack expected = new EnemyAttack();
        expected.setNumber(1);
        expected.setTitle("Bite");
        expected.setDescription("A single regular bite");
        expected.setHits(1);
        expected.setAoe(false);
        expected.setAccuracy(70);
        expected.setMult(1);
        expected.setDazePercent(80);
        expected.setHeal(0);
        expected.setLeech(false);
        expected.setType(EnemyAttackType.PHYSICAL_ATTACK);
        expected.setTarget("Enemy");
        expected.setUsePotential(false);
        expected.setFlicker(0);
        expected.setPoints(20);
        expected.setBurnTime(0);
        expected.setPoisonTime(0);
        expected.setPhysicalDefenseDebuff(0);
        expected.setPhysicalDefenseTime(0);
        expected.setPhysicalDefenseChance(0);
        expected.setEtherAttackDebuff(0);
        expected.setEtherAttackTime(0);
        expected.setEtherAttackChance(0);
        expected.setEtherDefenseDebuff(0);
        expected.setEtherDefenseTime(0);
        expected.setEtherDefenseChance(0);
        expected.setPhysicalAttackDebuff(0);
        expected.setPhysicalAttackTime(0);
        expected.setPhysicalAttackChance(0);

        File file = new File("examples/enemy_attacks.json");
        EnemyAttack actual;
        try {
            actual = mapper.readValue(file, EnemyAttack[].class)[0];
        }
        catch (Exception e) {
            fail(e.getMessage());
            return;
        }

        assertEquals(expected, actual);
    }
}
