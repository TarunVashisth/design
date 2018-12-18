class AccountService
{
  Stack<Operation> stack = new Stack<Operation>();
  Account acc;
  
  AccountService(Account acc){
    this.acc = acc;
  }
  
  public void withdraw(double amount){
    acc.withdraw(amount);
    Operation op = new DepositOperation(amount, this.acc);
    stack.push(op);
  }
  
  public void deposit(double amount){
    acc.deposit(amount);
    Operation op = new WithdrawOperation(amount, this.acc);
    stack.push(op)
  }
  
  public void undo(){
    Operation op = stack.pop();
    op.performTransaction();  
  }
  
}
