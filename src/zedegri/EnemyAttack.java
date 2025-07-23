package zedegri;

public class EnemyAttack {
  private int num;
  private EnemyAttackType type;
  private String target;
  private boolean usePotential;
  private int flicker;
  private int points;

  public EnemyAttack() {
    this.num = 0;
    this.type = EnemyAttackType.PHYSICAL_ATTACK;
    this.target = "Enemy";
    this.usePotential = false;
    this.flicker = 0;
    this.points = 0;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public EnemyAttackType getType() {
    return type;
  }

  public void setType(EnemyAttackType type) {
    this.type = type;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public boolean isUsePotential() {
    return usePotential;
  }

  public void setUsePotential(boolean usePotential) {
    this.usePotential = usePotential;
  }

  public int getFlicker() {
    return flicker;
  }

  public void setFlicker(int flicker) {
    this.flicker = flicker;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public static EnemyAttack fromJson(String filePath) {
    return new EnemyAttack();
  }
  public String toJson() {
      return "";
  }
}
