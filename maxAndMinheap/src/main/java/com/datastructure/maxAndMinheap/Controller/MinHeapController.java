package com.datastructure.maxAndMinheap.Controller;

import org.springframework.web.bind.annotation.*;

import com.datastructure.maxAndMinheap.Service.MinHeap;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/minheap")
public class MinHeapController {
    private final MinHeap minHeap = new MinHeap(100);

    @PostMapping("/insert")
    public Mono<String> insert(@RequestParam int value) {
        minHeap.insert(value);
        return Mono.just("Value " + value + " inserted into the MinHeap.");
    }

    @DeleteMapping("/deleteMin")
    public Mono<String> deleteMin() {
        int minValue = minHeap.deleteMin();
        if (minValue != -1) {
            return Mono.just("Deleted Min element: " + minValue);
        } else {
            return Mono.just("MinHeap is empty. Cannot delete.");
        }
    }
    
    @DeleteMapping("/delete/{value}")
    public Mono<String> delete(@PathVariable int value) {
        int deletedValue = minHeap.delete(value);
        if (deletedValue != -1) {
            return Mono.just("Deleted element: " + deletedValue);
        } else {
            return Mono.just("Element not found in MinHeap.");
        }
    }
    
    @GetMapping("/getHeap")
    public Mono<int[]> getMinHeap() {
        return Mono.just(minHeap.toArray());
    }
}
