package baseball;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;

public class ApplicationTest extends NSTest {
    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void 스트라이크() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 3, 5);
            running("124");
            verify("1스트라이크");
        }
    }

    @Test
    void 볼() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 3, 5);
            running("217");
            verify("1볼");
        }
    }

    @Test
    void 낫싱() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("246");
            verify("낫싱");
        }
    }

    @Test
    void 정답() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 3, 5);
            running("135");
            verify("3스트라이크", "게임 끝");
        }
    }

    @Test
    void 게임_중_잘못된_입력() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(7, 1, 3)
                .thenReturn(5, 8, 9);
            run("abc", "a12", "1234", "11", " ", "713", "1", "589", "2");
            verify("[ERROR]", "[ERROR]", "[ERROR]", "[ERROR]", "[ERROR]", "3스트라이크", "게임 끝", "3스트라이크", "게임 끝");
        }
    }

    @Test
    void 게임종료_후_재시작() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(7, 1, 3)
                    .thenReturn(5, 8, 9);
            run("713", "1", "597", "589", "2");
            verify("3스트라이크", "게임 끝", "1스트라이크 1볼");
        }
    }

    @Test
    void 게임종료_후_잘못된_입력() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(7, 1, 3)
                .thenReturn(5, 8, 9);
            run("713", "0", "3", "1", "589", "2");
            verify("3스트라이크", "게임 끝", "[ERROR]", "[ERROR]", "숫자를 입력해주세요", "3스트라이크", "게임 끝");
        }
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
