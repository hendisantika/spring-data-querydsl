package hendisantika.domain.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Accessors(chain = true)
public class OtherDomain implements Serializable {

  private static final long serialVersionUID = -7738022816882911489L;

  @Id
  @GeneratedValue
  private Long id;
  private String test;
}
