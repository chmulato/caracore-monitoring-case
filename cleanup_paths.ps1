$root = 'D:\onedrive\outros\workspace_velsis'
$old = 'D:\onedrive\outros\workspace_velsis_hd'
$new = 'D:\onedrive\outros\workspace_velsis'
$extensions = @('.txt', '.md', '.json', '.xml', '.log')
$specialNames = @('clover.xml', 'coverage-final.json')

$count = 0
Get-ChildItem -Path $root -Recurse -File | Where-Object {
    $_.Extension -in $extensions -or $_.Name -in $specialNames
} | ForEach-Object {
    $content = Get-Content -Path $_.FullName -Raw -Encoding UTF8
    if ($content -like "*$old*") {
        $updated = $content.Replace($old, $new)
        Set-Content -Path $_.FullName -Value $updated -Encoding UTF8
        $count++
    }
}
Write-Host "Updated files: $count"
