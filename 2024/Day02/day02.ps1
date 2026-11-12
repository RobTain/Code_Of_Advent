function Is-Safe {
    param([int[]]$levels)

    $increasing = $true
    $decreasing = $true

    for ($i = 0; $i -lt $levels.Length - 1; $i++) {
        $diff = $levels[$i+1] - $levels[$i]

        # Differenz muss zwischen -3 und -1 (fallend) oder 1 und 3 (steigend) liegen
        if ($diff -lt -3 -or $diff -gt 3 -or $diff -eq 0) {
            return $false
        }

        if ($diff -lt 0) { $increasing = $false }
        if ($diff -gt 0) { $decreasing = $false }
    }

    return $increasing -or $decreasing
}

# read file 
$input = Get-Content -Path "H:\Dokumente\GIT\CoA_2024\Code_Of_Advent_2024\Day02\Input.txt"

# solution1
$count = 0
foreach ($line in $input) {
    if (Is-Safe($line -split ' ' | ForEach-Object { [int]$_ })) { $count++ }
}
Write-Host "Solution 1: $count"

# solution2
