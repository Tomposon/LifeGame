package LifeGame;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LifeGameTest {

	private GameMap gameMap;
	int[][] map;
	@Before
	public void setUp() throws Exception {
		gameMap=new GameMap();
		gameMap.initMap();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testCellProducedByRandomly() {
		//fail("Not yet implemented");
		
		//单元测试随机生成函数生成的地图的值是否只等于0或1
		
		int[][] map=new int[10][10];
		gameMap.cellProducedByRandomly(map);
		
		for(int i=0;i<map.length;i++)
			for(int j=0;j<map[0].length;j++)
			{
				if(map[i][j]!=0&&map[i][j]!=1)
					fail("random fail");
			}
	}

	@Test
	public void testGetNearCellStatusCount() {
		//fail("Not yet implemented");
		
		//测试（3,3）细胞周围的活细胞，有4个
		int[][] map = {
				{0,0,0,0,0,0},
				{0,1,0,0,0,0},
				{0,0,1,1,0,0},
				{0,0,0,0,0,0},
				{0,0,0,1,1,0},
				{0,0,0,0,0,0}
		
			};
		int count=gameMap.getNearCellStatusCount(3, 3, map);
		assertEquals(count,4);
	}

	@Test
	public void testChangeStatus() {
		//fail("Not yet implemented");
		
		//测试用例断言（3,3）细胞的下一状态，当前周围有3个活细胞，下一状态应该是活的
		
		int[][] tempStatus={
				{0,0,0,0,0,0},
				{0,1,0,0,0,0},
				{0,0,1,0,0,0},
				{0,0,0,0,0,0},
				{0,0,0,1,1,0},
				{0,0,0,0,0,0}
		};
		int[][] nextStatus={
				{0,0,0,0,0,0},
				{0,1,0,0,0,0},
				{0,0,1,0,0,0},
				{0,0,0,0,0,0},
				{0,0,0,1,1,0},
				{0,0,0,0,0,0}
		};
		gameMap.changeStatus(nextStatus, tempStatus);
		assertEquals(1,nextStatus[3][3]);
	}

	@Test
	public void testStartGame() {
		//fail("Not yet implemented");
		
		//因为cellProducedByRandomly函数已测试成功，这里测试startGame函数
		
		gameMap.cellProducedByRandomly(gameMap.getMap());
		boolean test=gameMap.startGame();
		
		assertEquals(test,true);
	}

	@Test
	public void testChangeToNext() {
		//fail("Not yet implemented");
		
		//测试是将一个数组赋值给另外一个数组。复制之后，断言tempStatus数组的元素全为0
		
		
		int[][] tempStatus={
				{0,0,0,0,0,0},
				{0,1,0,0,0,0},
				{0,0,1,0,1,0},
				{0,0,0,0,1,0},
				{0,0,0,1,1,0},
				{0,0,0,0,0,0}
		};
		int[][] nextStatus={
				{0,0,0,0,0,0},
				{0,0,0,0,0,0},
				{0,0,0,0,0,0},
				{0,0,0,0,0,0},
				{0,0,0,0,0,0},
				{0,0,0,0,0,0}
		};
		
		gameMap.changeToNext(tempStatus, nextStatus);
		
		for(int i=0;i<tempStatus.length;i++)
			for(int j=0;j<tempStatus[0].length;j++)
			{
				assertEquals(0,tempStatus[i][j]);
			}
	}

}
