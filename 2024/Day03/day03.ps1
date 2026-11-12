function solution1 {
    param($line)
    $result = 0;
    $matches = [regex]::Matches($line, "mul\((\d{1,3}),(\d{1,3})\)")
    foreach ($match in $matches) {
        $result += ([int]$match.Groups[1].Value.ToString() * [int]$match.Groups[2].Value.ToString())
    }
    return $result
}

function solution2 {
    param($line)
    $result = 0;

    $list = [regex]::Matches($line, "mul\((\d{1,3}),(\d{1,3})\)|do\(\)|don't\(\)")
    $check = $true
    foreach ($match in $list) {
        Write-Host $check
        Write-Host $match.Groups[0].Value
        if ($check) {
            $result += ([int]$match.Groups[1].Value.ToString() * [int]$match.Groups[2].Value.ToString())
        }
       
        if ($match.Groups[0].Value.ToString() -eq "don't()") {
            $check = $false
        } elseif ($match.Groups[0].Value.ToString() -eq "do()") {
            $check = $true
        }

    }

    return $result
}

# read file 
$input = Get-Content -Path "H:\Dokumente\GIT\CoA_2024\Code_Of_Advent_2024\Day03\Input.txt"

# solution1
$result = 0
foreach ($line in $input) {
    $result += solution1($line)
}

Write-Host "Solution 1: $result"

# solution2
$result = 0
foreach ($line in $input) {
    $result += solution2($line)
}

Write-Host "Solution 2: $result"
