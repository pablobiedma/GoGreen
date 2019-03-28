package groupxii.server.database;

import com.mongodb.DBObject;

public class UserCredentialsEntry extends Entry {
   private String username;
   private String password;
   private String recoveryEmail;

   UserCredentialsEntry(String username, String password, String recoveryEmail) {
      super();
      this.username = username;
      this.password = password;
      this.recoveryEmail = recoveryEmail;
   }

   public String getUsername() {
      return this.username;
   }

   public String getPassword() {
      return this.password;
   }

   public String getRecoveryEmail() {
      return this.recoveryEmail;
   }

   public toDbObject() {
      super.toBasicDbObject()
         .append("username", this.username)
         .append("password", this.password)
         .append("recoveryEmail", this.recoveryEmail);
   }
}
