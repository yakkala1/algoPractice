import java.io.*;
import java.util.*;

class Solution {
  
  int nRows = 9;
  int nCols = 9;
  Map<Position,Set<Character>> possiblesMap;
  char[][] board;

  char[][] solveSudoku(char[][] board) {
    this.board = board;
	  logBoard();
    intitializePossiblesMap(board);
    boolean ret = solve();
    log("ret : "+ret);
    return board;
  }
    
  private void logBoard() {
      for( int i=0; i<9; i++ ) {
          log( Arrays.toString(board[i]) );
      }
  }
    
  private boolean solve() {
    if( possiblesMap.size() == 0 ) {
        log(possiblesMap);
        logBoard();
        log("returning true");
      return true;
    }
    Position cell = getMinimum();
    log(cell);
    if( possiblesMap.get(cell).size() == 0 ) {
        log("returning false");
        return false;
    }
    Set<Character> possibles = possiblesMap.get(cell);
    log( "map : "+possiblesMap );
    log("possibles : "+possibles);
    for( Character value : possibles ) {
      Map<Position,Set<Character>> prevMap = clone(possiblesMap);
      log(cell+":"+value);
      log("prevMap : "+prevMap);
      fill( cell , value );
      log("prevMap : "+prevMap);
      boolean ret = solve();
      if( ret==true )
          return true;
      log(cell+":"+value+" : fail");
      undoFill( cell , value , prevMap );
      log("undoing with prevMap : "+prevMap);
      log("map : "+possiblesMap);
    }
    log( "tried everything; returning false : " );
    return false;
  }
    
  private Map<Position, Set<Character>> clone(Map<Position, Set<Character>> map) {
	  Map<Position,Set<Character>> ret = new HashMap<Solution.Position, Set<Character>>();
	  for(Position pos : map.keySet()) {
		  Position key = new Position(pos.i,pos.j);
		  Set<Character> value = new HashSet<Character>();
		  value.addAll( map.get(key) );
		  ret.put(key, value);
	  }
	  return ret;
  }

void fill
    ( Position cell , char c ) 
  {
    possiblesMap.remove( cell );
    board[cell.i][cell.j] = c;
    int row = cell.i;
    int col = cell.j;
    int box = getBox(row,col);
    removeFromRow( row , c );
    removeFromCol( col , c );
    removeFromBox( box , c );
  }
    
  void undoFill
    ( Position cell , char c , Map<Position,Set<Character>> prevMap ) 
  {
    this.possiblesMap = prevMap;
    this.board[cell.i][cell.j] = '.';
  }
  
  void intitializePossiblesMap(char[][] board) {
    possiblesMap = new HashMap<Position,Set<Character>>();
    for( int i=0; i<nRows; i++ ) {
      for( int j=0; j<nCols; j++ ) {
        if( board[i][j] == '.' )
          possiblesMap.put( new Position(i,j) , oneToNineSet() );
      }
    }
    for( int i=0; i<board.length; i++ ) {
      for( int j=0; j<board[0].length; j++ ) {
        if( board[i][j] != '.' ) {
          char c = board[i][j];
          int row = i;
          int col = j;
          int box = getBox(i,j);
          removeFromRow( i , c );
          removeFromCol( j , c );
          removeFromBox( box , c );
        }
      }
    }
  }
    
  private void log(Object obj) {
      System.out.println(obj);
  }
  
  Set<Character> oneToNineSet() {
    Set<Character> list = new HashSet<Character>();
    for( int i=1; i<=9; i++ ) {
      list.add( (i+"").charAt(0) );
    }
    return list;
  }
  
  private int getBox(int i, int j) {
    int boxI = i/3;
    int boxJ = j/3;
    return 3*boxI + boxJ;
  }
  
  private List<Position> getPositionsOfBox(int box) {
    List<Position> ret = new ArrayList<Position>();
    int boxI = box/3;
    int boxJ = box%3;
    for( int i=0; i<3; i++ ) {
      for( int j=0; j<3; j++ ) {
        Position pos = new Position( 3*boxI+i , 3*boxJ+j );
        ret.add( pos );
      }
    }
    return ret;
  }
  
  private void removeFromRow( 
    int row , char c ) 
  {
    for( int i=0; i<=nCols; i++ ) {
      Position pos = new Position(row,i);
      if( possiblesMap.containsKey(pos) )
        possiblesMap.get(pos).remove(c);
    }
  }
    
  private void removeFromCol( 
    int col , char c ) 
  {
    for( int i=0; i<=nRows; i++ ) {
      Position pos = new Position(i,col);
      if( possiblesMap.containsKey(pos) )
        possiblesMap.get(pos).remove(c);
    }
  }
    
  private void removeFromBox( 
    int box , char c ) 
  {
    List<Position> positions = getPositionsOfBox(box);
    for( Position pos : positions ) {
      if( possiblesMap.containsKey(pos) )
        possiblesMap.get(pos).remove(c);
    }
  }

  Position getMinimum(  ) {
    Position min = null;
    for( Position pos : possiblesMap.keySet() ) {
      if( min == null )
        min = pos;
      else if( possiblesMap.get(pos).size() < possiblesMap.get(min).size() )
        min = pos;
    }
    return min;
  }
  
  class Position {
    public int i,j;
    public Position(int i, int j) {
      this.i = i;
      this.j = j;
    }
    @Override
    public int hashCode() {
        return 17*Integer.hashCode(i)+Integer.hashCode(j);
    }
    @Override
    public boolean equals(Object obj) {
        Position other = (Position)obj;
        return i==other.i && j==other.j;
    }
    @Override
    public String toString() {
      return String.format("(%d,%d)",i,j);
    }
  }

}

class Logger {
	
	public static void log(Object obj) {
		System.out.println(obj);
	}
	
}