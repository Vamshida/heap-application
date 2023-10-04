package com.datastructure.maxAndMinheap.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datastructure.maxAndMinheap.Service.MaxHeap;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/maxheap")
public class MaxHeapController {
    private final MaxHeap maxHeap = new MaxHeap(100);

    @PostMapping("/insert")
    public Mono<String> insert(@RequestParam int value) {
        maxHeap.insert(value);
        return Mono.just("Value " + value + " inserted into the MaxHeap.");
    }

    @DeleteMapping("/deletemax")
    public Mono<String> deleteMax() {
        int maxValue = maxHeap.deleteMax();
        if (maxValue != -1) {
            return Mono.just("Deleted Max element: " + maxValue);
        } else {
            return Mono.just("MaxHeap is empty. Cannot delete.");
        }
    }
    
    @DeleteMapping("/delete/{value}")
    public Mono<String> deleteValue(@PathVariable int value) {
        int deletedValue = maxHeap.delete(value);
        if (deletedValue != -1) {
            return Mono.just("Deleted element: " + deletedValue);
        } else {
            return Mono.just("Element not found in MaxHeap.");
        }
    }
    
    @GetMapping("/getheap")
    public Mono<int[]> getMaxHeap() {
        return Mono.just(maxHeap.toArray());
    }
}
