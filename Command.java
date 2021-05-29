package com.company;

public interface Command {
    /**
     * return void
     * name Execute
     * modificator public
     * @param command
     * @throws Exception
     */
    public void Execute(String command) throws Exception;

    /**
     * name getName
     * modificator public
     * @return
     */
    public String getName();
}
