package edu.odu.cs.cs350;
public class TextBlock {
    private:
        String TextBlock;
        List<Tokens> Tokens;
        
    TextBlock(String BlockText){
        this.TextBlock = String BlockText;
    }
    
    public:
        void setTextBlock(String AssignedBlock) {
            this.TextBlock = String AssignedBlock;
        }

        String getTextBlock() {
            return this.TextBlock;
        }

        void setTokens(List<Tokens> AssignedTokens) {
            this.Tokens = List<Tokens> AssignedTokens;
        }

        List<Tokens> getTokens() {
            return this.Tokens;
        }

        List<Tokens> createTokens(String BlockText) {}

    
}