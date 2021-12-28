package dataStructure.tree.heap;

import java.util.NoSuchElementException;

/**
 * 참고 : https://st-lab.tistory.com/205
 * Heap 의 특별한 성질들
 * <p>
 * 1. 왼쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2
 * 2. 오른쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 1
 * 3. 부모 노드 인덱스 = 자식 노드 인덱스 / 2
 */

public class MinHeap<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array; // 요소를 담을 배열
    int size;

    public MinHeap() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // 받은 인덱스의 부모 노드 인덱스를 반환
    private int getParents(int index) {
        return index / 2;
    }

    // 받은 인덱스의 왼쪽 자식 노드 인덱스를 반환
    private int getLeftChild(int index) {
        return index * 2;
    }

    // 받은 인덱스의 오른쪽 자식 노드 인덱스를 반환
    private int getRightChild(int index) {
        return index * 2 + 1;
    }

    private void resize(int newCapacity) {

        // 새로 만들 배열
        Object[] newArray = new Object[newCapacity];

        // 새 배열에 기존에 있던 배열의 요소들을 모드 복사해준다.
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            newArray[i] = array[i];
        }

        /*
         *  현재 배열은 GC 처리를 위해 null로 처리한 뒤,
         *  새 배열을 연결해준다.
         */
        this.array = null;
        this.array = newArray;
    }

    public void add(E value) {
        if (DEFAULT_CAPACITY + 1 == array.length) {
            resize(array.length * 2);
        }
        siftUp(size + 1, value);
        size++;
    }

    private void siftUp(int idx, E target) {
        siftUpComparable(idx, target);
    }

    private void siftUpComparable(int idx, E target) {
        // 타겟노드가 비교 될 수 있도록 한 변수를 만든다.
        Comparable<? super E> comp = (Comparable<? super E>) target;

        while (idx > 1) {
            int parent = getParents(idx);
            Object parentVal = array[parent];

            if (comp.compareTo((E) parentVal) >= 0) {
                break;
            }
            array[idx] = parentVal;
            idx = parent;
        }
        array[idx] = comp;
    }

    public E remove() {
        if (array[1] == null) {
            throw new NoSuchElementException();
        }

        E result = (E) array[1];
        E target = (E) array[size];
        array[size] = null;
        siftDown(1, target);

        return result;
    }

    private void siftDown(int idx, E target) {
        siftDownComparable(idx, target);
    }


    private void siftDownComparable(int idx, E target) {
        Comparable<? super E> comp = (Comparable<? super E>) target;

        array[idx] = null; // 삭제 할 인덱스의 노드를 삭제
        size--;

        int parent = idx; // 삭제노드부터 시작 할 부모를 가르키는 변수
        int child; // 교환 될 자식을 가르키는 변수

        // 왼쪽 자식 노드의 인덱스가 요소의 개수보다 작을 때 까지 반복
        while((child = getLeftChild(parent)) <= size) {

            int right = getRightChild(parent); // 오른쪽 자식 인덱스

            Object childVal = array[child]; // 왼쪽 자식의 값 ( 교환 될 값 )

            /*
             *  오른쪽 자식 인덱스가 size를 넘지 않으면서
             *  왼쪽 자식이 오른쪽 자식보다 큰 경우
             *  재배치 할 노드는 작은 자식과 비교해야하므로 child와 childVal을
             *  오른쪽 자식으로 바꿔준다.
             */

            if (right <= size && ((Comparable<? super E>) childVal).compareTo((E) array[right]) > 0) {
                child = right;
                childVal = array[child];
            }

            // 재배치 할 노드가 자식 노드보다 작을경우 반복문을 종료한다.
            if (comp.compareTo((E) childVal) <= 0) {
                break;
            }

            /*
             *  현재 부모 인덱스에 자식 노드 값을 대체해주고
             *  부모 인덱스를 자식 인덱스로 교체
             */

            array[parent] = childVal;
            parent = child;
        }

        // 최종적으로 재배치 되는 위치에 타겟이 된 값을 넣어준다.
        array[parent] = comp;

        /*
         *  용적의 사이즈가 최소 용적보다는 크면서 요소의 개수가 전체 용적의 1/4일경우
         *  용적을 반으로 줄임(단, 최소용적보단 커야함)
         */
        if (array.length > DEFAULT_CAPACITY && size < array.length / 4) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }
    }
}
