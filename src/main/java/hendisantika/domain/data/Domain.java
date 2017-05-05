package hendisantika.domain.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Accessors(chain = true)
public class Domain implements Serializable {

  private static final long serialVersionUID = 7217062414225635846L;

  @Id
  @GeneratedValue
  private Long id;
  private String username, firstName, lastName;

  @OneToOne
  private OtherDomain otherDomain;
}
